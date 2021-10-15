
# Microservicio-ibm-proyecto-banco


Esta API realiza una busqueda del cajero o sucursal mas cercano según el código postal o 
ciudad ingresada por el usuario

Todo desde el puerto: 8080

Ejemplo: localhost:8080/banco

ventasparsot@gmail.com

## API Reference

#### Obtener el la sucursal o banco mas cercano según el código postal o ciudad

```http
  POST /banco
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `codigoPostal` | `Integer` | Código postal a 5 números |
| `ciudad` | `String` | Nombre de la ciudad|





  
## Capturas de POSTMAN

![App Screenshot](https://i.postimg.cc/tRYzshrX/Screenshot-2.png)
![App Screenshot](https://i.postimg.cc/P5zWgKqM/Screenshot-3.png)
