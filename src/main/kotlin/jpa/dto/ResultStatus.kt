package net.dhant.dto

/**
 * basically web result
 */
data class ResultStatus(
        /** st */
        var st: String,
        /** message */
        var msg: String? = ""
)