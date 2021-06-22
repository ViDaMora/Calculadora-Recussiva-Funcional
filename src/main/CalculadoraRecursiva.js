
let suma = (a,b)=>{
    return a+b
}

let resta = (a,b)=>{
    return a-b
}


let divisionDiscreta = (a,b)=>{
    if (resta(a,b)<0)
        return 0
    return divisionDiscreta(resta(a,b),b) +1

}

let multiplicacionDiscreta = (a,b)=>{
    if(a == 1)
        return b
    return suma(multiplicacionDiscreta(resta(a,1),b),b)
}


let divisionDiscretaPorComposicion = (a,b,func)=>{
    if (func(a,b)<0)
        return 0
    return divisionDiscreta(func(a,b),b) +1
}


let multiplicacionDiscretaPorComposicion = (a,b,funcplus,funcrest)=>{
    if(a == 1)
        return b
    return funcplus(multiplicacionDiscretaPorComposicion(funcrest(a,1),b,funcplus,funcrest),b)
}


console.log(multiplicacionDiscreta(5,7))
//console.log(divisionDiscretaPorComposicion(7,7,resta))
//onsole.log(multiplicacionDiscretaPorComposicion(7,7,suma,resta))