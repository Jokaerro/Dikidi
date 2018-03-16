package inc.tesla.dikidi.application

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


object DateUtils {

    val API_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss"

    internal val DATE_PATTERN = "HH:mm aaa, dd MMM yyyy"

    @SuppressLint("SimpleDateFormat")
    private val DATE_FORMAT = SimpleDateFormat(DATE_PATTERN)


    fun toString(date: Date?): String = DATE_FORMAT.format(date)

}
