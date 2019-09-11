package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
    }

    public void update(Resume resume) {
        getEquals(resume);
    }

    public void save(Resume resume) {
        for (int j = 0; j < storage.length; j++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            } else {
                getEquals(resume);
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                for (int k = count; k < count - 1; k++)
                    storage[k] = storage[k + 1];
                count--;
                break;
            } else {
                System.out.println("Error: The resume doesn't exist");
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    public void getEquals(Resume value) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(value.getUuid())) {
                storage[i] = value;
                count++; //ошибка NPE или не происходит запись uuid
                break;
            } else {
                System.out.println("Error: ... ");
                break;
            }
        }
    }
}