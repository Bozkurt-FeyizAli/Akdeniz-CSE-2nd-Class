 public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, 
    OLSON, RYAN, PRS, ANY; 
    public String toString() { 
    switch(this) { 
    case FENDER: return "Fender"; 
    case MARTIN: return "Martin";
    case GIBSON: return "gibson";
    case COLLINGS: return"collings";
    case OLSON: return "olson";
    case RYAN: return "ryan";
    case PRS: return"prs";
    case ANY: return "any";
    default: return "unspecified";
}
} 
}
