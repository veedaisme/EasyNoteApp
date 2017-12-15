package com.vibelous.iqbaaaaalf.easynoteskotlin.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by iqbaaaaalf on 12/13/2017.
 */
class Util {
    companion object {

        fun getTodayPlusDays(day: Int): Date{
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, day)
            return calendar.time
        }

        fun getTodayDay(): Date{
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, 0)
            return calendar.time
        }

        /*
           1 Week random day from today
         */

        fun getRandomDayFromToday(): Date{
            val date = getTodayPlusDays((1..7).random())
            return date
        }

        fun getDayMonthString(date: Date): String{
            val sdf = SimpleDateFormat("dd/MM")
            return sdf.format(date).toString()
        }

        fun getSimpleDate(date: Date): String{
            val sdf = SimpleDateFormat("EEE, d MMM")
            return sdf.format(date).toString()
        }

        fun ClosedRange<Int>.random() =
                Random().nextInt(endInclusive - start) +  start
    }


}