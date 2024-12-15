import java.util.logging.*;

public class LoggerExample {

    public static void main(String[] args) {
        // Создание логгера
        Logger logger = Logger.getLogger(LoggerExample.class.getName());

        // Настройка обработчика для вывода логов в консоль
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINEST);  // Включаем FINEST и выше
        logger.addHandler(consoleHandler);

        // Установка уровня логирования для логгера
        logger.setLevel(Level.FINEST); // Логгер обрабатывает FINEST и выше

        // Логирование на разных уровнях
        logger.severe("Сообщение уровня SEVERE");  // Очень серьезная ошибка
        logger.warning("Сообщение уровня WARNING");  // Предупреждение
        logger.info("Сообщение уровня INFO");  // Общая информация
        logger.config("Сообщение уровня CONFIG");  // Конфигурационная информация
        logger.fine("Сообщение уровня FINE");  // Базовая отладочная информация
        logger.finer("Сообщение уровня FINER");  // Более подробная отладочная информация
        logger.finest("Сообщение уровня FINEST");  // Самая подробная отладочная информация

        // Дополнительная логика для демонстрации
        doComplexTask();
    }

    // Пример метода, где логируются события с разной детализацией
    public static void doComplexTask() {
        Logger logger = Logger.getLogger(LoggerExample.class.getName());
        logger.fine("Запуск выполнения сложной задачи...");
        try {
            // Здесь мы можем симулировать какое-то исключение
            logger.finer("Обработка части задачи...");
            throw new Exception("Исключение в задаче");
        } catch (Exception e) {
            logger.warning("Предупреждение: Ошибка в процессе выполнения задачи: " + e.getMessage());
            logger.severe("Серьезная ошибка: " + e.getMessage());
        } finally {
            logger.finest("Завершение выполнения задачи...");
        }
    }
}