package com.aspen_compose.mockup

import com.aspen_compose.R
import com.aspen_compose.model.Hostel

object Mockup {

    fun cities(): List<String>{
        return listOf(
            "Utah",
            "Washington",
            "Idaho",
            "Nebraska",
            "Minnesota",
            "New Hampshire",
            "Iowa",
            "Wisconsin",
            "Vermont",
            "Florida"
        )
    }
    fun hostels(): List<Hostel> {
        return listOf(
            Hostel(
                0,
                R.drawable.popular_mockup3,
                "Alley Palace",
                "4.1",
                "235",
                "Alley Palace is a beachfront apartment in Angisa, offering guests a sustainable accommodation with scenic sea views. Among the facilities at this property are a 24-hour front desk and a lift, along with free WiFi throughout the property.",
                "$89",
                listOf(
                    "1 Heater",
                    "Dinner",
                    "2 Tub",
                ),
                listOf(
                    R.drawable.ic_wifi,
                    R.drawable.ic_food,
                    R.drawable.ic_bath_tub,
                )
            ),
            Hostel(
                1,
                R.drawable.popular_mockup2,
                "Coeurdes Alpes",
                "4.5",
                "355",
                "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and ....",
                "$199",
                listOf(
                    "1 Heater",
                    "Dinner",
                    "1 Tub",
                    "Pool"
                ),
                listOf(
                    R.drawable.ic_wifi,
                    R.drawable.ic_food,
                    R.drawable.ic_bath_tub,
                    R.drawable.ic_frame
                )
            ),
            Hostel(
                2,
                R.drawable.popular_mockup1,
                "Radisson Blu Hotel",
                "4.9",
                "1353",
                "The Radisson Blu Rostov-on-Don Hotel is located on the Don Embankment. The windows offer panoramic views of the river and the city center. Guests can enjoy the bar and restaurant. The reception is open 24 hours a day, and it offers a fitness center, a relaxation area and private parking. High-speed Wi-Fi is available throughout the hotel.",
                "$259",
                listOf(
                    "1 Heater",
                    "Dinner",
                    "1 Tub",
                    "Pool"
                ),
                listOf(
                    R.drawable.ic_wifi,
                    R.drawable.ic_food,
                    R.drawable.ic_bath_tub,
                    R.drawable.ic_frame
                )
            )

        )
    }

    fun getHostelById(id: Int): Hostel = hostels()[id]

}