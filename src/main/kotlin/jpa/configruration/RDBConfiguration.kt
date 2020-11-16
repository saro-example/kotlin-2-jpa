package jpa.configruration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.io.IOException
import javax.sql.DataSource

@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("jpa.repository")
class RDBConfiguration (

        @Value("\${rdb.driverClassName}")
        private val driverClassName: String,

        @Value("\${rdb.jdbcUrl}")
        private val jdbcUrl: String,

        @Value("\${rdb.username}")
        private val username: String,

        @Value("\${rdb.password}")
        private val password: String

) {
    @Bean
    @Throws(IOException::class)
    fun dataSource(): DataSource
            = HikariConfig()
            .let {
                it.driverClassName = driverClassName
                it.jdbcUrl = jdbcUrl
                it.username = username
                it.password = password
                HikariDataSource(it)
            }
}
