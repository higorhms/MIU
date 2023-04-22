package prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Admin {
    //Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
    public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
		return Stream.of(members)
				.filter(member -> member
						.getCheckoutRecord()
						.getCheckoutEntryList()
						.stream()
						.map(CheckoutRecordEntry::getLendingItem)
						.toList()
						.contains(item))
				.map(LibraryMember::getPhone)
				.sorted(Comparator.naturalOrder())
				.toList();
    }
}
