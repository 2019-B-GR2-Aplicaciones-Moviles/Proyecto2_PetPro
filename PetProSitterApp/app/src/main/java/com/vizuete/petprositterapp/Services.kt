package com.vizuete.petprositterapp

class Services {
    var idUsuario: String? = null
    var servicio: String? = null
    var idTarjeta: String? = null
    var idCuidador: String? = null
    var valor: Number? = 0

    constructor() {}
    constructor(
        idUsuario: String?,
        servicio: String?,
        idTarjeta: String?,
        idCuidador: String?,
        valor: Number?
    ) {
        this.idUsuario = idUsuario
        this.servicio = servicio
        this.idTarjeta = idTarjeta
        this.idCuidador = idCuidador
        this.valor = valor
    }

}