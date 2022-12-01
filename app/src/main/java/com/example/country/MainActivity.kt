package com.example.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.country.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            val countryName = binding.etCountryName.text.toString() //greece

            lifecycleScope.launch{ // Так как ранее пометили функцию getCountrieByName как корутину, необходимо создать саму корутину
            val countries = restCountriesAPI.getCountrieByName(countryName) // Код будет выполнятся в фоном потоке параллельно с основным
            val country:Country=countries[0]

            binding.tvCountryName.text = country.name
            binding.tvCapital.text = country.capital
            binding.tvArea.text = country.area.toString()
            binding.tvPopulation.text = country.population.toString()
            binding.tvLanguages.text = country.languages[0].toString()
            binding.tvNameCurrencies.text = country.currencies[0].toString()
            binding.tvSymbolCurrencies.text = country.currencies[1].toString()}


        }
    }
}