package parkinglot.strategies.slotassignment;

import parkinglot.models.SlotAllotmentStrategyType;

import java.util.Stack;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotForType(SlotAllotmentStrategyType slotAllotmentStrategyType){
        return new RandomSlotAssignmentStrategy();
    }
}
