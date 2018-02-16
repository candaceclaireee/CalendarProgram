package designchallenge1.observer;

import facebook.FBView;

import java.time.LocalDate;

public class FBApp extends Observer {
    public FBApp(Subject sub) {
        app = new FBView();
        this.sub = sub;
    }

    @Override
    public void update() {
        // get something sa subject
        SystemDateExtractor s = new SystemDateExtractor();
        ColorConverter converter = new ColorConverter();
        s.extractSystem(LocalDate.now());

        for (Event currentEvent: sub.getData().getEvents()) {
            if (s.getMonth() == currentEvent.getMonth() && s.getDay() == currentEvent.getDay() && s.getYear() == currentEvent.getYear()
                    && currentEvent.getStatus() == false)
                app.showNewEvent(currentEvent.getTitle(), currentEvent.getMonth(),
                        currentEvent.getDay(), currentEvent.getYear(), converter.convertColor(currentEvent.getColor()));
        }
    }

    private FBView app;
}
