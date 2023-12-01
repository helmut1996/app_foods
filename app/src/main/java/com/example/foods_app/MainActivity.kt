package com.example.foods_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.lifecycleScope
import com.example.foods_app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var fakeDatabase: FakeDatabase
    @Inject lateinit var dataSource: DataSource
    private val TAG = "DEV"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAutoComplete()
        setupButton()
        setupButtonclear()

    }

    private fun clear() {
       with(binding){
           tilPrice.editText?.setText("")
           tilName.editText?.setText("")
           tilType.editText?.setText("")
       }
    }
    private fun setupAutoComplete() {
        val type = fakeDatabase.getAllTypes().map { it.name }
        val typeAdapter= ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,type)
        (binding.tilType.editText as? AutoCompleteTextView)?.setAdapter(typeAdapter)
    }

    private fun setupButtonclear(){
        binding.btnClear.setOnClickListener {
            clear()
        }
    }
    private fun setupButton(){
        binding.btnSave.setOnClickListener {
         val type = fakeDatabase.getAllTypes().first { it.name==binding.acType.text.toString()}.id
        val food = FoodEntity(
            price = binding.etPrice.text.toString().toDouble(),
            name = binding.etName.text.toString(),
            type = type.toLong()
        )
            saveFood(food)
        }
    }
    private fun saveFood(food:FoodEntity){
        lifecycleScope.launch {

            dataSource.addFood(food){ id->
                if (id< 1) {
                    Snackbar.make(binding.root, R.string.foodError, Snackbar.LENGTH_SHORT).show()
                }else{
                    Log.d(TAG, "Se Guardo el Registro")
                    Snackbar.make(binding.root, R.string.foodSuccess, Snackbar.LENGTH_SHORT).show()
                    clear()
                }
            }
        }
    }
}