package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (count > storage.length) {
            System.out.println("Error: The storage is already full");
        } else if (index < 0) {
            // typing code

            storage[count] = resume;
            count++;
        } else {
            System.out.println("Error: The " + resume.getUuid() + " is already into the storage ");
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(storage, 0, count)));
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey, Resume::compareTo);
    }
}