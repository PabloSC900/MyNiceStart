# MyNiceStart
[MyNiceStart en github](https://github.com/PabloSC900/MyNiceStart)

La idea principal de esta aplicación consiste en una plataforma digital que sirva como guia para encontrar restaurantes y locales de estilo asiatico en tu ciudad.
Las imagenes usadas estan pensadas de manera que le impriman ese caracter exotico para atraer al cliente, ademas de dejar clara la función principal de la app.
Los colores elgidos buscan armonizar con esta idea para que, al integrarlos junto con las imagenes, creen una "única paleta".

**Índice:**

* Splash
* Log In
* Sign Up
* Main
* Main2


**Splash**

La pantalla de Splash cuenta con:
* **Una ImageView**: para darle fondo.
* **Un VectorAsset**: sirve como logo para la aplicación

![](img/captura_splash.PNG)


**Log In**

La pantalla de Log In cuenta con:
* **Una ImageView**: para darle fondo.
* **Dos EditText**: para introducir usuario y contraseña
* **Un Button**: te permite acceder a la pestaña Main
* **Un TextView**: te redirige a la pestaña de Sign Up

![](img/captura_login.PNG)

**Sign Up**

La pantalla de Sign Up cuenta con:
* **Una ImageView**: para darle fondo.
* **Tres EditText**: para introducir correo, usuario y contraseña
* **Un Button**: actualmente sin función
* **Un TextView**: te redirige a la pestaña de Log In



![](img/captura_signup.PNG)


**Main**

La pantalla de Main cuenta con:
* **Una ImageView**: cargada con Glide.
* **Un Button**: te permite acceder al Main2
* **Un AppBar**: cada uno de sus iconos con una función
* **Un AlertDialog**: aparece al selecionar uno de los iconos del Appbar
* **Un SwipeRefesh con snackbar**: te permite refrescar la pestaña y, a continuación, deshacer la acción si asi lo deseas
* **Un ExpandableCardView**: al pulsar aparece una tarjeta para mostrar información. Puedes volver a ocultarla
* **Un Menu Contextual**: que surge al mantener pulsado la foto del centro de la pantalla, permietiendote elegir una de las dos opciones que muestra



![](img/captura_main.PNG)
![](img/captura_main_dialog.PNG)
![](img/captura_main_ec.PNG)
![](img/captura_main_swipe.PNG)




**Main2**

La pantalla de Main2 tan solo cuenta con:

* **Un MenuBottomBar**: un menu en la parte inferior de la pestaña con un botón flotante
*Una opción para volver a la panatalla Main, al pulsar la flecha situada en la parte superior izquierda

![](img/captura_main2.PNG)