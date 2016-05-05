package com.qoobico.remindme.server.service;

import com.qoobico.remindme.server.entity.Remind;

import java.util.List;

public interface ReminderService {

    List<Remind> getAll();
    Remind getByID(long id);
    Remind save(Remind remind);
    void remove(long id);

}
