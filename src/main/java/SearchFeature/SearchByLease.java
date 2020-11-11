package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByLease implements SearchInterface{
    Integer lease;
    ArrayList<Home> byLease;

    public SearchByLease(Integer lease) {
        this.lease = lease;
        byLease=new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList) {
            if (home.getLeaseLength() == (int)lease)
                byLease.add(home);
        }
        return byLease;
    }
}
