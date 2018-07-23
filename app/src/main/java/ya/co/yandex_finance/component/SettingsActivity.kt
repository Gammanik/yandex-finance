package ya.co.yandex_finance.component


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_settings.*
import ya.co.yandex_finance.R

class SettingsActivity : AppCompatActivity() {

    //todo: add name and back screen button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        text_about_app.setOnClickListener{ view ->
            AlertDialog.Builder(this@SettingsActivity)
                    .setView(R.layout.dialog_about)
                    .create()
                    .show()
        }
    }
}
