package com.vibelous.iqbaaaaalf.easynoteskotlin.util

import java.util.*

/**
 * Created by iqbaaaaalf on 12/13/2017.
 */
class Util {
    companion object {

        fun getTodayPlusDays(day: Int): Date{
            val calendar: Calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, day)
            return calendar.time
        }

        fun ClosedRange<Int>.random() =
                Random().nextInt(endInclusive - start) +  start
    }
}