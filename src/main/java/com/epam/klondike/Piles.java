package com.epam.klondike;

import java.util.ArrayList;
import java.util.List;

public class Piles {

  private List<Pile> piles;
  private int numberOfPiles = 7;

  public Piles() {
    piles = new ArrayList<>(numberOfPiles);
    for (int i = 0; i < numberOfPiles; i++){
      Pile pile = new Pile();
      piles.add(pile);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Piles piles1 = (Piles) o;

    return numberOfPiles == piles1.numberOfPiles &&
        !(piles != null ? !piles.equals(piles1.piles) : piles1.piles != null);

  }

  @Override
  public int hashCode() {
    int result = piles != null ? piles.hashCode() : 0;
    result = 31 * result + numberOfPiles;
    return result;
  }

  @Override
  public String toString() {
    return "Piles{" +
        "piles=" + piles +
        ", numberOfPiles=" + numberOfPiles +
        '}';
  }

  public int getNumberOfPiles() {
    return numberOfPiles;
  }

  private void setNumberOfPiles(int numberOfPiles){
    this.numberOfPiles = numberOfPiles;
  }

  public Pile getPile(int number){
    return piles.get(number);
  }

}
