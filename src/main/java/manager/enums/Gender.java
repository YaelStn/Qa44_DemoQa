package manager.enums;

public enum Gender {
//constanti
        MALE("//label[@for='gender-radio-1']"),
        FEMALE("//*[@for='gender-radio-2']"),
        OTHER("//*[@for='gender-radio-3']");
        private final String locator;
         // Конструктор перечисления, который присваивает локатор
        Gender(String locator) {
            this.locator = locator;
        }
        // Метод для получения локатора
        public String getLocator(){
            return locator;
        }
    }

