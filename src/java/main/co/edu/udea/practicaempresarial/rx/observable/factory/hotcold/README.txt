Observables hot y cold

Un observable tipo "cold" es aquel que se mantiene inactivo y no emite nada hasta que alguno se suscriba a él. Cada vez que alguno se suscribe, empieza a emitir notificaciones. Por ejemplo, si nos suscribimos 3 veces a un observable "cold", emitirá las notificaciones 3 veces. Los observables tipo cold producen notificaciones en demanda, y para cada suscritor producen notificaciones independientes.

Algunos observables de tipo cold son los que se pueden crear a partir de métodos como: Observable.create(), Observable.just() y Observable.from().

Los observables tipo "hot" son aquellos que empiezan a emitir notificaciones sin importar si hay suscritores o no. Emiten notificaciones hasta que finalizan. Todos los suscritores reciben las mismas notificaciones y por defecto, cuando alguno se suscribe, no recibe las notificaciones emitidas antes de eso.

Un ejemplo de observable tipo "hot" son los ConnectableObservable utilizando el método publish().

El método publish() puede ser utilizado para convertir cualquier observable a un tipo "hot".

Hay una forma de hacer que todas las notificaciones emitidas antes de las suscripción de un observable, éste las pueda recibir y continuar recibiendo las que llegan. Ésto se puede lograr utilizando el método relay() en lugar de publish(). Así, todos los observables reciben todas las notificaciones (todas las notificaciones van a llegar en orden y de forma síncrona).

Igualmente, hay una forma de activar un observable para que sea de tipo "hot" sin llamar el método connect(). Puede ser activado desde la primera suscripción y ser desactivado cuando cada suscriptor de desinscriba. Ésto se puede lograr con el método refCount(). Su nombre viene de "reference count" cuenta los suscriptores al observable. Se desactiva cuando ya no tiene más suscriptores y se vuelve a activar, cuando luego de eso hay alguno otro, al cual le notifica todos los eventos desde el inicio. Existe el método share(), el cual es un alias para el método publish().refCount().
