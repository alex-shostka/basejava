package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String fullName_1 = "fullName_1";
    private static final String fullName_2 = "fullName_2";
    private static final String fullName_3 = "fullName_3";
    private static final String fullName_4 = "fullName_4";

    private static final Resume resume_1 = new Resume(UUID_1, fullName_1);
    private static final Resume resume_2 = new Resume(UUID_2, fullName_2);
    private static final Resume resume_3 = new Resume(UUID_3, fullName_3);
    private static final Resume resume_4 = new Resume(UUID_4, fullName_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(resume_1);
        collection.add(resume_2);
        collection.add(resume_3);

        for (Resume r : collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
//                collection.remove(r);
            }
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, resume_1);
        map.put(UUID_2, resume_2);
        map.put(UUID_3, resume_3);

        // Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<Resume> resumes = Arrays.asList(resume_1, resume_2, resume_3);
        resumes.remove(1);
        System.out.println(resumes);
    }
}
