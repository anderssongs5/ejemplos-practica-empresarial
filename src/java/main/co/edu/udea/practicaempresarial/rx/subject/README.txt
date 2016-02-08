Las instancias Subject pueden ser tanto observables como observadores. Como instancias observables, pueden tener múltiples instancias observadoras recibiendo las mismas notificaciones. Es por esto que pueden ser usadas para convertir observables "cold" en "hot". Como observadores, Subject nos da acceso a los métodos onNext(), onError() y onCompleted().

Los 4 tipos de Subject en RxJava son:
* PublishSubject: Se comporta similar a un ConnectableObservable creado usando publish().

* ReplaySubject: emite a cualquier observador todos los ítems que fueron emitidos por el Observable fuente, independientemente de cuándo el observador se suscriba. Se comporta similar a un ConnectableObservable creado con replay(). Esta clase tiene múltiples métodos de fábrica. Por defecto, cachean todo, por lo que se debe tener en cuenta en términos de consumo de memoria. Hay métodos para crear instancias con buffer limitado por el tamaño y/o por tiempo. 

* BehaviorSubject: cuando un observador se suscribe, este tipo de subject emite el ítem más recientemente emitido por la fuente observable (o un valor por defecto o semilla si ningún ítem ha sido emitido) y luego emite cualquier otro ítem después por la fuente observable. La clase BehaviorSubject es similar a la clase ReplaySubject con un buffer de 1. Esta clase puede ser usada para implementar una instancia reactiva con estado.

* AsyncSubject: emite el último valor emitido por la fuente observable y solo después la fuente concluye o finaliza. Si la fuente no emite ningún valor, la instancia de AsyncObject finaliza sin emitir ningún valor.
