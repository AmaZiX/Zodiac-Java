/*
 * Copyright (C) 2017 Magic Eye
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.magiceye.zodiac;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.magiceye.zodiac.ZodiacSign.Sign;
import org.fusesource.jansi.Ansi.Color;
import static org.fusesource.jansi.Ansi.ansi;
import org.fusesource.jansi.AnsiConsole;

public class Zodiac {
    
    private static Scanner INPUT = new Scanner(System.in);
    
    private static char choice;
    private static boolean wontContinue;
    
    public static void main(String[] args){
        AnsiConsole.systemInstall();
        System.out.println(ansi().fg(Color.CYAN).a("\n\t\t+-------------------------------------+\n"
                + "\t\t|                                     |\n"
                + "\t\t|            ZODIAC SIGNS             |\n"
                + "\t\t|            by Magic Eye             |\n"
                + "\t\t|                                     |\n"
                + "\t\t+-------------------------------------+\n").reset());
            System.out.println("\tWe can tell who you are, we can see just by the birth.");
        do {
            System.out.println("\n\tThese choices determines your enthusiasm; choose wisely.\n");
            System.out.println(ansi().fgBright(Color.GREEN).bold().a("\t\tA - I want to know who I am.").reset());
            System.out.println(ansi().fgBright(Color.RED).bold().a("\t\tB - It's not necessary to know who am I.").reset());
            AnsiConsole.systemUninstall();
            System.out.print("\n\tChoice: ");
            String temp = INPUT.next().toUpperCase();
            if(temp.toCharArray().length == 1){
                choice = temp.charAt(0);
                switch(choice){
                    case 'A':
                        choice = 0;
                        wontContinue = false;
                        System.out.println("\n\tNow, if you please. We want to know your birthdate. (Format: DD/MM)\n\tExample: 01/12");
                        System.out.print("\tBirthdate: ");
                        String date = INPUT.next();
                        Sign s;
                        try {
                            s = ZodiacSign.getSignOfDate(date);
                        } catch (UWotException ex) {
                            wontContinue = true;
                            clearScreen();
                            System.out.println("\n\tU wot m8? // Unknown date and month. Program terminating...");
                            break;
                        }
                        clearScreen();
                        System.out.println("\n\tThis is what you have sought...\n\tYou are a " + s.getName() );
						System.out.println("\n\tDo you seek more of your fate?");
						System.out.print("\n\tRetry? (Y/N)")
						choice = INPUT.next().toUpperCase().charAt(0);
						switch(choice){
							case 'Y':
								wontContinue = false;
								clearScreen();
								break;
							case 'N':
								wontContinue = true;
								clearScreen();
								break;
							default:
								wontContinue = true;
								clearScreen();
								break;
						}
                        break;
                    case 'B':
                        choice = 0;
                        wontContinue = true;
                        clearScreen();
                        System.out.println("\n\tWe shall thy farewell.");
                        break;
                    default:
                        wontContinue = false;
                        clearScreen();
                        System.out.println("\n\tWe do not understand");
                        break;
                }
            }
            AnsiConsole.systemInstall();
        } while (!wontContinue);
        AnsiConsole.systemUninstall();
        System.exit(0);
    }
    
    private static void clearScreen(){
        try {
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
