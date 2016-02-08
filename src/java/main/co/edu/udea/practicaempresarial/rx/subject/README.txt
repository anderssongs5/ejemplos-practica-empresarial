Las instancias Subject pueden ser tanto observables como observadores. Como instancias observables, pueden tener m�ltiples instancias observadoras recibiendo las mismas notificaciones. Es por esto que pueden ser usadas para convertir observables "cold" en "hot". Como observadores, Subject nos da acceso a los m�todos onNext(), onError() y onCompleted().

Los 4 tipos de Subject en RxJava son:
* PublishSubject: Se comporta similar a un ConnectableObservable creado usando publish().
* ReplaySubject: emite a cualquier observador todos los �tems que fueron emitidos por el Observable fuente, independientemente de cu�ndo el observador se suscriba. Se comporta similar a un ConnectableObservable creado con replay(). Esta clase tiene m�ltiples m�todos de f�brica. Por defecto, cachean todo, por lo que se debe tener en cuenta en t�rminos de consumo de memoria.
				 Hay m�todos para crear instancias con buffer limitado por el tama�o y/o por tiempo. 
* BehaviorSubject: cuando un observador se suscribe, este tipo de subject emite el �tem m�s recientemente emitido por la fuente observable (o un valor por defecto o semilla si ning�n �tem ha sido emitido) y luego emite cualquier otro �tem despu�s por la fuente observable. La clase BehaviorSubject es similar a la clase ReplaySubject con un buffer de 1. Esta clase puede ser usada para implementar una instancia reactiva con estado.
* AsyncSubject: emite el �ltimo valor emitido por la fuente observable y solo despu�s la fuente concluye o finaliza. Si la fuente no emite ning�n valor, la instancia de AsyncObject finaliza sin emitir ning�n valor.
