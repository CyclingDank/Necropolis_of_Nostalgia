package com.turtledove.necropolisofnostalgia.packets;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import org.apache.logging.log4j.Level;
import org.lwjgl.Sys;

/**
 * The logging API. All logging should go through this class.
 *
 * @author _Bedrock_Miner_ (minerbedrock@gmail.com)
 */
public class Log {
    /**
     * Logs fatal errors which will crash the game with the standard modid of
     * Minersbasic.
     *
     * @param format    the format
     * @param arguments the arguments
     */
    public static void fatal(String format, Object... arguments) {
        Necropolis_of_Nostalgia.LOG.fatal(format, arguments);
    }

    /**
     * Logs an Error (probably recoverable) with the standard modid of
     * Minersbasic.
     *
     * @param text   the text
     * @param format the format
     */
    public static void error(String text, Object... format) {
        log(Level.ERROR, text, format);
    }


    /**
     * Logs general warnings with the standard modid of Minersbasic.
     *
     * @param text   the text
     * @param format the format
     */
    public static void warn(String text, Object... format) {
        log(Level.WARN, text, format);
    }


    /**
     * Logs an information with the standard modid of Minersbasic.
     *
     * @param text   the text
     * @param format the format
     */
    public static void info(String text, Object... format) {
        log(Level.INFO, text, format);
    }

    /**
     * Logs debug messages (only visible in the fml-client/server-latest.log
     * file) with the standard modid of Minersbasic
     *
     * @param text   the text
     * @param format the format
     */
    public static void debug(String text, Object... format) {
        log(Level.DEBUG, text, format);
    }


    /**
     * Logs trace messages (only visible in the fml-client/server-latest.log
     * file) with the standard modid of Minersbasic
     *
     * @param text   the text
     * @param format the format
     */
    public static void trace(String text, Object... format) {
        log(Level.TRACE, text, format);
    }

    private static void log(Level level, String text, Object... format) {
        Necropolis_of_Nostalgia.LOG.log(level, String.format(text, format));
    }

    /**
     * Logs the call of the currently active method for debugging.
     * <p>
     * This code:<br>
     * <code>public void onUpdate() {
     * Log.called();
     * }</code><br>
     * Leads to this output:<br>
     * <code>Called EnclosingClass.onUpdate() [line: line] at system time
     * currentSystemTime in thread CurrentThread.</code>
     *
     * @deprecated Marked as deprecated to remind the modder of removing the
     * method calls
     * before publishing the mod.
     */
    @Deprecated
    public static void called() {
        Thread t = Thread.currentThread();
        StackTraceElement top = t.getStackTrace()[2];
        Log.info("Called %s.%s() [line: %s] at system time %s in thread %s.", top.getClassName().substring(top.getClassName().lastIndexOf(".") + 1), top.getMethodName(), top.getLineNumber(), Sys.getTime() * 1000L / Sys.getTimerResolution(), t.getName());
    }

    /**
     * Prints the currently active method. Useful for errors that were recovered
     * instead of being thrown as an exception.
     * <p>
     * The output is:<br>
     * <code>at: AnyClass.anyMethod() [line: line].</code><br>
     * The output is printed as an error message.
     */
    public static void printCurrentMethod() {
        StackTraceElement top = Thread.currentThread().getStackTrace()[2];
        Log.error("at: %s.%s() [line: %s].", top.getClassName().substring(top.getClassName().lastIndexOf(".") + 1), top.getMethodName(), top.getLineNumber());
    }
}