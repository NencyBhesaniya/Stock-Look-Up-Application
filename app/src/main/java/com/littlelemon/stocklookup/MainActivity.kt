package com.littlelemon.stocklookup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.littlelemon.stocklookup.viewmodel.StockViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val stockViewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBar = findViewById<EditText>(R.id.searchBar)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val stockInfo = findViewById<TextView>(R.id.stockInfo)

        // Trigger search when the button is clicked
        searchButton.setOnClickListener {
            val symbol = searchBar.text.toString().trim()

            if (symbol.isNotEmpty()) {
                stockViewModel.searchStock(symbol)
            }
        }

        // Observe the stock data and update the UI when the data changes
        stockViewModel.stockData.observe(this) { prices ->
            if (prices != null && prices.isNotEmpty()) {
                val stock = prices[0] // Get the first entry in the price list

                // Convert the timestamp to MM/dd/yyyy format
                val date = formatDate(stock.date)

                // Display the stock information
                stockInfo.text = """
                Date: $date
                Opened at price: ${stock.open} Rs.
                Highest Price: ${stock.high} Rs.
                Lowest Price: ${stock.low} Rs.
                Closed at price: ${stock.close} Rs.
                """.trimIndent()
            } else {
                stockInfo.text = "No stock data found"
            }
        }

        // Observe any errors and display them
        stockViewModel.error.observe(this) { error ->
            if (error != null) {
                stockInfo.text = error
            }
        }
    }

    // Function to convert timestamp to MM/dd/yyyy format
    private fun formatDate(timestamp: Long): String {
        // Convert seconds to milliseconds
        val date = Date(timestamp * 1000)
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return sdf.format(date)
    }
}
