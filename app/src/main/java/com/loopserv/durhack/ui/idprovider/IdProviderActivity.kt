package com.loopserv.durhack.ui.idprovider

import android.R.attr.mimeType
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.loopserv.durhack.ui.StateManager
import com.loopserv.durhack.ui.home.HomeActivity
import com.loopserv.durhack.ui.longquestions.LongQuestionsActivity
import kotlinx.android.synthetic.main.activity_id_provider.*
import java.io.File


class IdProviderActivity : AppCompatActivity() {

    lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.loopserv.durhack.R.layout.activity_id_provider)
        window.statusBarColor = Color.parseColor("#fafafa")

        id_next.text = "Take picture"
        id_next.setOnClickListener {
            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                val photo = File(externalCacheDir, "Pic-${System.currentTimeMillis()}.jpg")
                val apkURI = FileProvider.getUriForFile(
                    this@IdProviderActivity, this@IdProviderActivity.getApplicationContext()
                        .getPackageName().toString() + ".provider", photo
                )
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)


                putExtra(
                    MediaStore.EXTRA_OUTPUT,
                    apkURI
                )
                imageUri = Uri.fromFile(photo)
            }, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        println("Got result: $requestCode , $resultCode")

        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            println("Success in getting image")
            println("uri: $imageUri")

            Glide.with(this)
                .load(imageUri)
                .into(id_image)

            StateManager.applicationIdUrl = imageUri

            id_next.text = "Next"
            id_next.setOnClickListener {
                startActivity(Intent(this, LongQuestionsActivity::class.java))
                finish()
            }
        }
    }
}
