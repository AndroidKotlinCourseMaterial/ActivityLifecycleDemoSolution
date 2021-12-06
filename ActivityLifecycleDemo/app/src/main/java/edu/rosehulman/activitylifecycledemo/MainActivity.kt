package edu.rosehulman.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import edu.rosehulman.activitylifecycledemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
    }

    private fun setupButtons() {
        binding.buttonToast.setOnClickListener {
            Log.d(Constants.TAG, "Clicked toast button")
            Toast.makeText(this, "Clicked toast button", Toast.LENGTH_LONG).show()
        }

        binding.buttonDialog.setOnClickListener {
            Log.d(Constants.TAG, "Clicked dialog button")
            // TODO: make dialog
        }

        binding.fab.setOnClickListener {
            Log.d(Constants.TAG, "Clicked FAB = floating action button")
            // TODO: launch intent
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(Constants.TAG, "onStart() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.TAG, "onStop() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Constants.TAG, "onPause() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Constants.TAG, "onResume() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Constants.TAG, "onDestroy() called")
    }
}