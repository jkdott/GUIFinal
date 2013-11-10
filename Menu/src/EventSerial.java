/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calandar;

import day.*;
import java.io.*;
/**
 *
 * @author Lucas
 */
public class EventSerial extends EventDay implements Serializable {
    private static final long serialVersionUID = 6656263667918851453L;
    public EventSerial(String leader, String date) {
        super(leader, date);
    }
}
