package com.vengateshm.CovidDashboard.data;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private final String[] FIELD_NAMES = new String[]{"State", "Total Cases", "Total Deaths", "Total Recovered", "Active Cases",
            "Total Cases Per One Mil Population", "Death Per One Mil Population", "Total Tests", "Tests Per One Mil Population", "Population"};

    @Bean
    public FlatFileItemReader<StateCovidSummaryInput> reader() {
        return new FlatFileItemReaderBuilder<StateCovidSummaryInput>()
                .name("StateCovidSummaryItemReader")
                .resource(new ClassPathResource("covid-data.csv"))
                .linesToSkip(1)
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(StateCovidSummaryInput.class);
                }})
                .build();
    }

    @Bean
    public StateCovidSummaryDataProcessor processor() {
        return new StateCovidSummaryDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<StateCovidSummary> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<StateCovidSummary>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO state_covid_summary (state, total_cases, total_deaths, total_recovered, " +
                        "active_cases, total_cases_per_one_mil_population, death_per_one_mil_population, total_tests, " +
                        "tests_per_one_mil_population, population) " +
                        "VALUES (:state,:totalCases,:totalDeaths,:totalRecovered,:activeCases,:totalCasesPerOneMilPopulation,:deathPerOneMilPopulation,:totalTests,:testsPerOneMilPopulation,:population)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<StateCovidSummary> writer) {
        return stepBuilderFactory
                .get("step1")
                .<StateCovidSummaryInput, StateCovidSummary>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
