#define MAXN 1024
unsigned int dp[MAXN][MAXN];

void shorten(char *s, char *t) {
    bool exist[256] = {0};
    for(; *t; t++) exist[*t] = true;
    char *ptr = s;
    while(*s) {
        if(exist[*(s++)]) *(ptr++) = *(s - 1);
    }
    *ptr = 0;
}

int numDistinct(char * s, char * t){
    shorten(s, t);
    const int slen = strlen(s), tlen = strlen(t);
    if(slen == 0 ||tlen == 0) return 0;
    dp[0][0] = s[0] == t[0];
    for(int i = 1; i < slen; i++) {
        dp[0][i] = (s[i] == t[0]) + dp[0][i - 1];
    }
    for(int r = 1; r <tlen; r++) {
        dp[r][r-1] = 0;
        for(int c = r; c < slen; c++) {
            if(t[r] == s[c])
                dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
            else
                dp[r][c] = dp[r][c - 1];
        }
    }
    return (int)dp[tlen - 1][slen - 1];
}

