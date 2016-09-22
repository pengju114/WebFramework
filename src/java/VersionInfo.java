/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luzhenwen
 */
public class VersionInfo {
    public static String getVersionName(){
        return "1.0";
    }
    public static int getVersionCode(){
        return Integer.parseInt(getVersionName().replaceAll("\\.", ""));
    }
}
