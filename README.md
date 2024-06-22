# Conversor-de-monedas
Conversor de monedas utilizando una API.

---------------Librerias utilizadas----------------------
El programa fue creado con Java-17 y Gson-11.0, y se utilizó "IntelliJ IDEA Community Edition 2024.1.3" como ambiente de desarrollo.
Esta creado para funcionar en la consola.


------------------API (paquete "api")---------------------
Para este proyecto se esta utilizando la api Exchange Rate API (https://www.exchangerate-api.com/), la cual solicita una llave para poder ser manipulada, si se desea cambiar la llave hay que cambiar el atributo "keyApi" de la clase "ConectarApiExchangeRate".
El código esta abierto a recibir una API de conversión diferente, solo debe implementar la interface "ConectarApi" la cual pide la conversación de una moneda a otra (tambien hay que estar atentos a la configuración de los archivos).


------------------Archivos necesarios (paquete "archivos")--------------------
El programa necesita 2 archivos para un funcionamineto correcto.
1) (Indispensable) Para leer las distintas denominaciones (monedas) admitidas para la conversión, el programa crea un menu apartir de este archivo; el archivo debe persentar la siguiente configuración de datos:
       nombreDelaMonedaEnSingular,nombreDelaMonedaEnPlural,contraccion
       Los tres valores deben estar separados por una coma (,), y cada renglón es un tipo de moneda.
       El programa usa la parte de "contraccion" como la llave de la api para buscar su valor de equivalencia, por lo que si se usa una Api diferente hay que tener cuidando con el valor dado.
El programa ya trae un archivo predefinido, se encuentra en la raíz de proyecto y se llama "Monedas.txt", puedes editarlo para agregar más tipos de monedas o cambiar su configuración para que se adapte a otras APIs.
2) (Opcional) Un archivo que almacene el registro de conversiones en forma de Json, si este archivo no se encuentra al principio el programa mandará un mensaje de error pero no detendra su operación y al realizar la primera conversión se creará el archivo.
El programa ya trae un archivo predefinido, se encuentra en la raíz de proyecto y se llama "RegistroDeConversiones.txt".


-------------------Configuración inicial (paquete "principal")------------------------
En la clase "Principal" se creá un objeto de tipo "Control", a través de los parametros de contrucctor se va configurando tanto los archivos como la API:
    public Control(ConectarApi api, String direcionDenominaciones, String archivoRegistros) throws IOException {
        ...
    }
Como primer parámetro enviamos la clase que conectará con la Api, puedes usar la predeterminada (ConectarApiExchangeRate) o puedes pasar tu propia clase.
Como segundo parámetro debemos estcribir la dirección del archivo donde leerá las opciones de tipos de moneda disponibles.
Como tercer parámetro  debemos escribir la dirección donde se encuentra el archivo en el que guardaremos el registro de coversiones.
