package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("some_name" + i));
            }
        } catch (StorageException e) {
            Assert.fail("The storage is full");
        }
        storage.save(new Resume("OverFlow"));
    }
}
