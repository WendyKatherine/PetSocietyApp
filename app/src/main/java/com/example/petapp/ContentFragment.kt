package com.example.petapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.net.Uri
import android.widget.VideoView
import android.widget.MediaController
import android.webkit.WebView
import android.widget.EditText
import android.widget.Button
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat


class ContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    fun actualizarTexto(seccion: String) {
        val layoutContenido = view?.findViewById<ViewGroup>(R.id.layoutContenido)
        layoutContenido?.removeAllViews()

        when (seccion) {
            "Sección: Perfil" -> {
                val img = ImageView(requireContext())
                img.setImageResource(R.drawable.imgprofile)
                img.layoutParams = ViewGroup.LayoutParams(300, 300).apply {
                    var gravity = Gravity.CENTER_HORIZONTAL
                }
                img.scaleType = ImageView.ScaleType.CENTER_CROP
                img.clipToOutline = true
                img.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_image_bg)

                val nombre = TextView(requireContext()).apply {
                    id = R.id.txtPerfilNombre        // <-- necesitas este id en res/values/ids.xml o en tu layout
                    text = "🐾 Tabata Nala"
                    textSize = 24f
                    setTextColor(Color.WHITE)
                    setPadding(0, 16, 0, 8)
                }

                val descripcion = TextView(requireContext())
                descripcion.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut diam velit, vulputate a augue at, ornare commodo justo... Ver más"
                descripcion.textSize = 16f
                descripcion.setTextColor(Color.LTGRAY)
                descripcion.setPadding(0, 0, 0, 16)

                val publicador = TextView(requireContext())
                publicador.text = "Publicado por: Wendy K. Gomez Villa\nFecha: 07/04/2025"
                publicador.textSize = 14f
                publicador.setTextColor(Color.GRAY)
                publicador.setPadding(0, 24, 0, 0)

                val datos = listOf(
                    "📏 Peso: 10kg",
                    "🎨 Color: Brown",
                    "🤝 Social: Amistoso",
                    "💉 Vacunas: Sí"
                )

                layoutContenido?.addView(img)
                layoutContenido?.addView(nombre)
                layoutContenido?.addView(descripcion)

                datos.forEach { dato ->
                    val item = TextView(requireContext())
                    item.text = dato
                    item.textSize = 16f
                    item.setTextColor(Color.WHITE)
                    item.setPadding(0, 0, 0, 8)
                    layoutContenido?.addView(item)
                }

                layoutContenido?.addView(publicador)
            }


            "Sección: Video" -> {
                val titulo = TextView(requireContext()).apply {
                    text = "🎥 Video"
                    textSize = 24f
                    setTextColor(Color.WHITE)
                    setPadding(0, 100, 0, 24)
                    gravity = Gravity.CENTER
                }

                val videoContainer = FrameLayout(requireContext()).apply {
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        1200
                    ).apply {
                        setMargins(0, 0, 0, 32)
                    }
                }

                val videoView = VideoView(requireContext()).apply {
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    val uri = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.dog}")
                    setVideoURI(uri)

                    val mediaController = MediaController(requireContext())
                    mediaController.setAnchorView(this)
                    setMediaController(mediaController)
                    start()
                }

                videoContainer.addView(videoView)

                layoutContenido?.addView(titulo)
                layoutContenido?.addView(videoContainer)
            }


            "Sección: Botones" -> {
                val titulo = TextView(requireContext()).apply {
                    text = "🎮 Botones interactivos"
                    textSize = 20f
                    setTextColor(Color.WHITE)
                    gravity = Gravity.CENTER
                    setPadding(0, 0, 0, 32)
                }

                val mensaje = TextView(requireContext()).apply {
                    text = "Presiona un botón :)"
                    textSize = 18f
                    setTextColor(Color.LTGRAY)
                    gravity = Gravity.CENTER
                    setPadding(0, 0, 0, 32)
                }

                fun crearBoton(texto: String, onClick: (Button) -> Unit): Button {
                    return Button(requireContext()).apply {
                        text = texto
                        setTextColor(Color.WHITE)
                        textSize = 16f
                        background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg_red)
                        setPadding(48, 24, 48, 24)

                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply {
                            gravity = Gravity.CENTER
                            topMargin = 16
                            bottomMargin = 16
                        }

                        setOnClickListener { onClick(this) }
                    }
                }

                val btn1 = crearBoton("Cambiar color") {
                    it.setBackgroundColor(Color.MAGENTA)
                    mensaje.text = "¡Botón 1 cambió de color!"
                }

                val btn2 = crearBoton("Mostrar mensaje") {
                    mensaje.text = "¡Hola mundo! 💥"
                }

                val btn3 = crearBoton("Desactivar botón") {
                    it.isEnabled = false
                    mensaje.text = "Botón 3 desactivado 😴"
                }

                layoutContenido?.addView(titulo)
                layoutContenido?.addView(mensaje)
                layoutContenido?.addView(btn1)
                layoutContenido?.addView(btn2)
                layoutContenido?.addView(btn3)
            }



            "Sección: Web" -> {
                val titulo = TextView(requireContext()).apply {
                    text = "🌐 Navega en la Web"
                    textSize = 20f
                    setTextColor(Color.WHITE)
                    gravity = Gravity.CENTER
                    setPadding(0, 0, 0, 24)
                }

                val campoUrl = EditText(requireContext()).apply {
                    hint = "Escribe una URL (ej: https://google.com)"
                    setText("https://www.google.com")
                    setHintTextColor(Color.LTGRAY)
                    setTextColor(Color.WHITE)
                    setPadding(32, 24, 32, 24)
                    background = ContextCompat.getDrawable(requireContext(), R.drawable.edittext_bg)
                }

                val botonIr = Button(requireContext()).apply {
                    text = "Ir"
                    setTextColor(Color.WHITE)
                    setBackgroundColor(Color.parseColor("#F73A44"))
                    setPadding(32, 24, 32, 24)

                    val params = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply {
                        gravity = Gravity.CENTER
                        topMargin = 24
                        bottomMargin = 24
                    }
                    layoutParams = params
                }

                val webView = WebView(requireContext()).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        1200
                    )
                    settings.javaScriptEnabled = true
                }

                botonIr.setOnClickListener {
                    val url = campoUrl.text.toString()
                    webView.loadUrl(url)
                }

                layoutContenido?.addView(titulo)
                layoutContenido?.addView(campoUrl)
                layoutContenido?.addView(botonIr)
                layoutContenido?.addView(webView)
            }




            "Sección: Fotos" -> {
                val fotos = listOf(
                    Pair(R.drawable.pet1, "Descripción de la foto 1"),
                    Pair(R.drawable.pet2, "Descripción de la foto 2"),
                    Pair(R.drawable.pet3, "Descripción de la foto 3"),
                    Pair(R.drawable.pet4, "Descripción de la foto 4")
                )
                // Listas de IDs que definimos en ids.xml
                val imgIds  = listOf(R.id.imgFoto1, R.id.imgFoto2, R.id.imgFoto3, R.id.imgFoto4)
                val descIds = listOf(R.id.txtDesc1, R.id.txtDesc2, R.id.txtDesc3, R.id.txtDesc4)

                fotos.forEachIndexed { index, (imgRes, descripcion) ->
                    val container = LinearLayout(requireContext()).apply {
                        orientation = LinearLayout.VERTICAL
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply { setMargins(0,24,0,24) }
                    }

                    val image = ImageView(requireContext()).apply {
                        id = imgIds[index]                              // ← aquí el ID fijo
                        setImageResource(imgRes)
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            500
                        )
                        background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_image_bg)
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        clipToOutline = true
                    }

                    val desc = TextView(requireContext()).apply {
                        id = descIds[index]                             // ← y aquí también
                        text = descripcion
                        visibility = View.GONE
                        setPadding(16,8,16,16)
                        setTextColor(Color.LTGRAY)
                    }

                    image.setOnClickListener {
                        desc.visibility = if (desc.visibility == View.GONE) View.VISIBLE else View.GONE
                    }

                    container.addView(image)
                    container.addView(desc)
                    layoutContenido?.addView(container)
                }
            }



            else -> {

            }
        }
    }

}
