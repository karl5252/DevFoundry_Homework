package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.logging.Logger;
public class ISExceptionExtension implements TestExecutionExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(ISExceptionExtension.class.getName());



    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalStateException){
            LOGGER.info("ignored Illegal State Exception");

        }else{
            throw throwable;        }

    }
}
