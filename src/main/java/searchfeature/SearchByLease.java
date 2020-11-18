package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByLease implements SearchInterface{
    Integer lease;
    ArrayList<Home> byLease;

    public SearchByLease(Integer lease) {
        this.lease = lease;
        byLease=new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList) {
            if (home.getLeaseLength() == (int)lease)
                byLease.add(home);
        }
        return byLease;
    }
}
