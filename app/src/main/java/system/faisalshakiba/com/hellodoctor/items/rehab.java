/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.faisalshakiba.com.hellodoctor.items;


/**
 *
 * @author root
 */

public class rehab {

    int re_id;
    String name;
    String description;
    int own_number;
    String location;
    String lat_long;
    String help_service;
    int rating;

    public rehab() {
    }

    public rehab(int re_id, String name, String description, int own_number, String location, String lat_long, String help_service, int rating) {
        this.re_id = re_id;
        this.name = name;
        this.description = description;
        this.own_number = own_number;
        this.location = location;
        this.lat_long = lat_long;
        this.help_service = help_service;
        this.rating = rating;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwn_number() {
        return own_number;
    }

    public void setOwn_number(int own_number) {
        this.own_number = own_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat_long() {
        return lat_long;
    }

    public void setLat_long(String lat_long) {
        this.lat_long = lat_long;
    }

    public String getHelp_service() {
        return help_service;
    }

    public void setHelp_service(String help_service) {
        this.help_service = help_service;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "rehab{" + "re_id=" + re_id + ", name=" + name + ", description=" + description + ", own_number=" + own_number + ", location=" + location + ", lat_long=" + lat_long + ", help_service=" + help_service + ", rating=" + rating + '}';
    }
    
    
}
