package com.msstudent.ie.carbonfree.Controller;

import com.msstudent.ie.carbonfree.business.TrackData;
import com.msstudent.ie.carbonfree.data.Track;
import com.msstudent.ie.carbonfree.data.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/trackRecord")
public class TrackRecordController {


    private TrackRepository trackRepository;
    @Autowired
    public TrackRecordController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(@RequestBody TrackData trackData) {
        try {

            if (trackRepository.existsByReferenceCode(trackData.getReferenceCode())) {
                return ResponseEntity.badRequest().body("Reference code already exists.");
            }

            Track trackRecord = new Track();
            trackRecord.setReferenceCode(trackData.getReferenceCode());
            trackRecord.setSaveDate(trackData.getDate());

            Map<String, Map<String, Integer>> dataMap = trackData.getData();
            for (Map.Entry<String, Map<String, Integer>> entry : dataMap.entrySet()) {
                String dayOfWeek = entry.getKey();
                Map<String, Integer> values = entry.getValue();

                int distance = values.get("distance");
                int carbonFootprint = values.get("carbonFootprint");

                // Set the distance and carbonFootprint for the corresponding day
                switch (dayOfWeek) {
                    case "Monday":
                        trackRecord.setMondayDistance(distance);
                        trackRecord.setMondayCarbonFootprint(carbonFootprint);
                        break;
                    case "Tuesday":
                        trackRecord.setTuesdayDistance(distance);
                        trackRecord.setTuesdayCarbonFootprint(carbonFootprint);
                        break;
                    case "Wednesday":
                        trackRecord.setWednesdayDistance(distance);
                        trackRecord.setWednesdayCarbonFootprint(carbonFootprint);
                        break;
                    case "Thursday":
                        trackRecord.setThursdayDistance(distance);
                        trackRecord.setThursdayCarbonFootprint(carbonFootprint);
                        break;
                    case "Friday":
                        trackRecord.setFridayDistance(distance);
                        trackRecord.setFridayCarbonFootprint(carbonFootprint);
                        break;
                    default:
                        // Handle unsupported day of week
                        break;
                }
            }
            // Save the data to the database
            trackRepository.save(trackRecord);

        // Return the reference code in the response
            return ResponseEntity.ok(trackRecord.getReferenceCode());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
            }
    }


    @GetMapping("/findRecord")
    public ResponseEntity<TrackData> getTrackRecord(@RequestParam String referenceCode) {
        try {
            // Retrieve the track record from the database based ons the reference code
            Track trackRecord = trackRepository.findByReferenceCode(referenceCode);
            TrackData trackData = new TrackData();
            trackData = convertToTrackData(trackRecord);

            if (trackData != null) {
                // Return the track record in the response
                return ResponseEntity.ok(trackData);
            } else {
                // Return a not found response if the reference code doesn't match any record
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public TrackData convertToTrackData(Track track) {
        TrackData trackData = new TrackData();
        trackData.setDate(track.getSaveDate());
        trackData.setReferenceCode(track.getReferenceCode());

        Map<String, Map<String, Integer>> data = new HashMap<>();
        data.put("Monday", createDayData(track.getMondayDistance(), track.getMondayCarbonFootprint()));
        data.put("Tuesday", createDayData(track.getTuesdayDistance(), track.getTuesdayCarbonFootprint()));
        data.put("Wednesday", createDayData(track.getWednesdayDistance(), track.getWednesdayCarbonFootprint()));
        data.put("Thursday", createDayData(track.getThursdayDistance(), track.getThursdayCarbonFootprint()));
        data.put("Friday", createDayData(track.getFridayDistance(), track.getFridayCarbonFootprint()));
        trackData.setData(data);

        return trackData;
    }

    private Map<String, Integer> createDayData(int distance, int carbonFootprint) {
        Map<String, Integer> dayData = new HashMap<>();
        dayData.put("distance", distance);
        dayData.put("carbonFootprint", carbonFootprint);
        return dayData;
    }


}
