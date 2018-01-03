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

import java.util.Date;

public class ZodiacSign {
    
    /**
     * Determine the sign of date.
     * @param date The date to find
     * @return Sign of the corresponding date.
     */
    public static Sign getSignOfDate(String date) throws UWotException{
        int year = 2001;
        String[] raw = date.split("/");
        int day = Integer.parseInt(raw[0]);
        int month = Integer.parseInt(raw[1]);
        if(day > 31 || day < 1){
            throw new UWotException();
        }
        if(month > 12 || month < 1){
            throw new UWotException();
        }
        Date using = new Date();
        using.setDate(day);
        using.setMonth(month);
        if(day >= 22 && month == 12){
            year -= 1;
        }
        using.setYear(year);
        if(using.before(Sign.Capricorn.getBefore()) && using.after(Sign.Capricorn.getAfter())){
            return Sign.Capricorn;
        } else if(using.before(Sign.Aquarius.getBefore()) && using.after(Sign.Aquarius.getAfter())){
            return Sign.Aquarius;
        } else if(using.before(Sign.Pisces.getBefore()) && using.after(Sign.Pisces.getAfter())){
            return Sign.Pisces;
        } else if(using.before(Sign.Aries.getBefore()) && using.after(Sign.Aries.getAfter())){
            return Sign.Aries;
        } else if(using.before(Sign.Taurus.getBefore()) && using.after(Sign.Taurus.getAfter())){
            return Sign.Taurus;
        } else if(using.before(Sign.Gemini.getBefore()) && using.after(Sign.Gemini.getAfter())){
            return Sign.Gemini;
        } else if(using.before(Sign.Cancer.getBefore()) && using.after(Sign.Cancer.getAfter())){
            return Sign.Cancer;
        } else if(using.before(Sign.Leo.getBefore()) && using.after(Sign.Leo.getAfter())){
            return Sign.Leo;
        } else if(using.before(Sign.Virgo.getBefore()) && using.after(Sign.Virgo.getAfter())){
            return Sign.Virgo;
        } else if(using.before(Sign.Libra.getBefore()) && using.after(Sign.Libra.getAfter())){
            return Sign.Libra;
        } else if(using.before(Sign.Scorpio.getBefore()) && using.after(Sign.Scorpio.getAfter())){
            return Sign.Scorpio;
        } else if(using.before(Sign.Sagittarius.getBefore()) && using.after(Sign.Sagittarius.getAfter())){
            return Sign.Sagittarius;
        }
        return null;
    }

    public static enum Sign {
        Capricorn("Capricorn", new Date(2000, 12, 22), new Date(2001, 1, 20)), Aquarius("Aquarius", new Date(2001, 1, 21), new Date(2001, 2, 18)), Pisces("Pisces", new Date(2001, 2, 19), new Date(2001, 3, 20)), 
        Aries("Aries", new Date(2001, 3, 21), new Date(2001, 4, 20)), Taurus("Taurus", new Date(2001, 4, 21), new Date(2001, 5, 20)), Gemini("Gemini", new Date(2001, 5, 21), new Date(2001, 6, 21)), 
        Cancer("Cancer", new Date(2001, 6, 22), new Date(2001, 7, 22)), Leo("Leo", new Date(2001, 7, 23), new Date(2001, 8, 23)), Virgo("Virgo", new Date(2001, 8, 24), new Date(2001, 9, 23)), 
        Libra("Libra", new Date(2001, 9, 24), new Date(2001, 10, 23)), Scorpio("Scorpio", new Date(2001, 10, 24), new Date(2001, 11, 22)), Sagittarius("Sagittarius", new Date(2001, 11, 23), new Date(2001, 12, 21));
        
        private String name;
        private Date before, after;
        
        Sign(String s, Date afterD, Date beforeD){
            name = s;
            after = afterD;
            before = beforeD;
        }
        String getName(){
            return name;
        }
        Date getBefore(){
            return before;
        }
        Date getAfter(){
            return after;
        }
    }
    
}
