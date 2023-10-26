#!/bin/bash

# シェルスクリプトのディレクトリパスを取得
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# 出力ディレクトリの設定
OUTPUT_PATH="$DIR/../"

echo "Starting OpenAPI code generation..."

java -jar "$DIR/openapi-generator-cli-6.6.0.jar" generate \
  -i "$DIR/openapi.yaml" \
  -g spring \
  -o "$OUTPUT_PATH" \
  -c "$DIR/openapi.json"

# コード生成が成功したかを確認
if [ $? -eq 0 ]; then
    echo "OpenAPI code generation completed successfully!"
else
    echo "OpenAPI code generation failed!"
fi
