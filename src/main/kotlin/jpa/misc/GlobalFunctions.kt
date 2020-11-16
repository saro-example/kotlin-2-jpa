package jpa.misc

import jpa.JpaExampleApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.stream.Stream
import java.util.stream.StreamSupport

inline fun <reified T> logger(): Logger = LoggerFactory.getLogger(T::class.java)

inline fun resource(path: String) = JpaExampleApplication::class.java.getResource(path)!!

inline fun ymd(localDate: LocalDate = LocalDate.now()) = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))!!

inline fun <T> toStream(iterator: Iterator<T>): Stream<T> =
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
