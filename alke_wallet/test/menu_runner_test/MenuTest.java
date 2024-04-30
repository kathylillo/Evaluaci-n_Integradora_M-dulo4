package menu_runner_test;
/**
 * Impor de Clase abstracta Menu 
 */
import menu_runner.Menu;

/**
 * Importaciones necesarias para las pruebas
 */
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Menu.
 */
class MenuTest {
    private Menu menu;
    private InputStream originalSystemIn;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        menu = new Menu() {
            @Override
            public void displayMenu() {
                
                System.out.println("1. Opción 1");
                System.out.println("2. Opción 2");
            }
        };
        
        originalSystemIn = System.in;
    }

    /**
     * Restaurar el entorno después de cada prueba.
     */
    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    /**
     * Prueba para validar la entrada de usuario correcta en getUserChoice().
     */
    @Test
    @DisplayName("Prueba de entrada válida para getUserChoice()")
    void testGetUserChoiceValidInput() {
        
        provideInput("1\n");

       
        int choice = menu.getUserChoice();

       
        assertEquals(1, choice);
    }

    /**
     * Prueba para validar la excepción lanzada en caso de entrada de usuario inválida en getUserChoice().
     */
    @Test
    @DisplayName("Prueba de entrada inválida para getUserChoice()")
    void testGetUserChoiceInvalidInput() {
        
        provideInput("abc\n");

      
        assertThrows(InputMismatchException.class, () -> {
            menu.getUserChoice(); // Debería lanzar InputMismatchException
        });
    }

    /**
     * Prueba para verificar el comportamiento de clearScreen().
     */
    @Test
    @DisplayName("Prueba para clearScreen()")
    void testClearScreen() {
        
        ByteArrayOutputStream outputStream = redirectStandardOutput();

        menu.clearScreen();

        assertAll(
            () -> assertEquals("\033[H\033[2J", outputStream.toString(), "La salida no coincide con la limpieza de pantalla"),
            () -> assertNotNull(outputStream, "No se capturó la salida estándar correctamente")
        );
    }

    /**
     * Prueba para verificar el cierre del Scanner en closeScanner().
     */
    @Test
    @DisplayName("Prueba para closeScanner()")
    void testCloseScanner() {
        // Act & Assert
        assertDoesNotThrow(() -> menu.closeScanner(), "Cerrar Scanner no debería lanzar excepciones");
    }

    /**
     * Método de utilidad para proporcionar entrada simulada en System.in.
     *
     * @param data Datos de entrada simulada.
     */
    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    /**
     * Método de utilidad para redirigir la salida estándar y capturarla.
     *
     * @return ByteArrayOutputStream que captura la salida estándar.
     */
    private ByteArrayOutputStream redirectStandardOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }
}