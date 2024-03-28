package com.torchtech.customalertdialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val showButton = findViewById<Button>(R.id.showButton)

        showButton.setOnClickListener {
            val inflater = layoutInflater.inflate(R.layout.custom_alert_layout,null)
            val builder = AlertDialog.Builder(this)
            builder.setView(inflater)

            val yesButton = inflater.findViewById<Button>(R.id.yesButton)
            val noButton = inflater.findViewById<Button>(R.id.noButton)

            val dialog = builder.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            yesButton.setOnClickListener {
                dialog.dismiss()
            }
            noButton.setOnClickListener {

                dialog.dismiss()
            }
            dialog.show()
        }
    }
}