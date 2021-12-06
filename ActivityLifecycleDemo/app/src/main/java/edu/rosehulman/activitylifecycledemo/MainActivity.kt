package edu.rosehulman.activitylifecycledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import edu.rosehulman.activitylifecycledemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.TAG, "onCreate() called")
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
            val dialog = AlertDialog.Builder(this)
                .setTitle("I'm an AlertDialog!")
                .setPositiveButton(android.R.string.ok) { dialog, which -> Log.d(Constants.TAG, "Dialog OK button pressed") }
                .show()
//                dialog.setPositiveButton(android.R.string.ok) {dialog, which -> Log.d(Constants.TAG, "Dialog OK button pressed")}
        }

        binding.fab.setOnClickListener {
            Log.d(Constants.TAG, "Clicked FAB = floating action button")
            // From https://developer.android.com/guide/components/intents-common#ComposeEmail
            composeEmail(arrayOf("boutell@gmail.com"), "Demo app")
        }
    }

    private fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, "Your demo app mailed you this - it's not spam!")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
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