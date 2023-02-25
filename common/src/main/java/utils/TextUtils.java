package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.NONE)
public class TextUtils {

    @SuppressWarnings("unchecked")
    public static String getListAsPrettyString(List<?> list) {
        list.sort(ComparatorUtils.NATURAL_COMPARATOR);
        StringBuilder result = new StringBuilder();
        boolean firstElement = true;
        for (Object element : list) {
            Assert.notNull(element, String.format("Null %s from a list cannot be written as String.", element.getClass().getName()));
            if (firstElement) {
                result.append(StringUtils.capitalize(element.toString()));
                firstElement = false;
            } else {
                result.append(" | ".concat(StringUtils.capitalize(element.toString())));
            }
        }
        return result.toString();
    }

    public static boolean allEmptyStrings(String... strings) {
        return allEmptyStrings(Arrays.asList(strings));
    }

    private static boolean allEmptyStrings(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        return list.stream().allMatch(StringUtils::isBlank);
    }
}
