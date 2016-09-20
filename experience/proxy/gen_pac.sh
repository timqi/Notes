#!/bin/bash

GFWLIST=https://raw.githubusercontent.com/gfwlist/gfwlist/master/gfwlist.txt
USER_RULE_LIST=
PROXY="SOCKS5 127.0.0.1:1080; SOCKS 127.0.0.1:1080; DIRECT"
DEST_PAC_PATH=

CURRENT_PATH=$(cd $(dirname $0) && pwd)
GEN_PATH=$CURRENT_PATH/gen
GFWLIST_TEXT_PATH=$GEN_PATH/gfwlist.txt
USER_RULE_TEXT_PATH=$GEN_PATH/user_rule.txt

if [ ! -d $GEN_PATH ]; then
  mkdir $GEN_PATH
fi

echo "Downloading gfwlist from $GFWLIST"
curl "$GFWLIST" > $GFWLIST_TEXT_PATH

echo "Downloading user_rule from $USER_RULE_LIST"
curl "$USER_RULE_LIST" > $USER_RULE_TEXT_PATH

/usr/local/bin/gfwlist2pac \
  --input $GFWLIST_TEXT_PATH \
  --file $CURRENT_PATH/g.pac \
  --proxy "SOCKS5 $PROXY; SOCKS $PROXY; DIRECT" \
  --user-rule $USER_RULE_TEXT_PATH \
  --precise

rm -rf $GEN_PATH
mv $CURRENT_PATH/g.pac $DEST_PAC_PATH
