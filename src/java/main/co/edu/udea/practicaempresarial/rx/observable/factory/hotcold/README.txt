Observables hot y cold

Un observable tipo "cold" es aquel que se mantiene inactivo y no emite nada hasta que alguno se suscriba a �l. Cada vez que alguno se suscribe, empieza a emitir notificaciones. Por ejemplo, si nos suscribimos 3 veces a un observable "cold", emitir� las notificaciones 3 veces. Los observables tipo cold producen notificaciones en demanda, y para cada suscritor producen notificaciones independientes.

Algunos observables de tipo cold son los que se pueden crear a partir de m�todos como: Observable.create(), Observable.just() y Observable.from().

Los observables tipo "hot" son aquellos que empiezan a emitir notificaciones sin importar si hay suscritores o no. Emiten notificaciones hasta que finalizan. Todos los suscritores reciben las mismas notificaciones y por defecto, cuando alguno se suscribe, no recibe las notificaciones emitidas antes de eso.

Un ejemplo de observable tipo "hot" son los ConnectableObservable utilizando el m�todo publish().

El m�todo publish() puede ser utilizado para convertir cualquier observable a un tipo "hot".

Hay una forma de hacer que todas las notificaciones emitidas antes de las suscripci�n de un observable, �ste las pueda recibir y continuar recibiendo las que llegan. �sto se puede lograr utilizando el m�todo relay() en lugar de publish(). As�, todos los observables reciben todas las notificaciones (todas las notificaciones van a llegar en orden y de forma s�ncrona).

Igualmente, hay una forma de activar un observable para que sea de tipo "hot" sin llamar el m�todo connect(). Puede ser activado desde la primera suscripci�n y ser desactivado cuando cada suscriptor de desinscriba. �sto se puede lograr con el m�todo refCount(). Su nombre viene de "reference count" cuenta los suscriptores al observable. Se desactiva cuando ya no tiene m�s suscriptores y se vuelve a activar, cuando luego de eso hay alguno otro, al cual le notifica todos los eventos desde el inicio. Existe el m�todo share(), el cual es un alias para el m�todo publish().refCount().
